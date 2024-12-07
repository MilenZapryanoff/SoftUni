terraform {
  required_providers {
    azurerm = {
      source  = "hashicorp/azurerm"
      version = "4.11.0"
    }
  }
}


provider "azurerm" {
  subscription_id = "6a552c94-0736-402d-b8eb-ff288478ee38"
  features {
  }
}

#recource for applying random number to name
resource "random_integer" "ri" {
  min = 10000
  max = 99999
}

#add resource group
resource "azurerm_resource_group" "TaskBoard-rg" {
  location = "North Europe"
  name     = "TaskBoard-${random_integer.ri.result}"
}

#add service plan
resource "azurerm_service_plan" "TaskBoard-asp" {
  name                = "taskbook-service-plan-${random_integer.ri.result}"
  resource_group_name = azurerm_resource_group.TaskBoard-rg.name
  location            = azurerm_resource_group.TaskBoard-rg.location
  os_type             = "Linux"
  sku_name            = "F1"
}

#add azure linux Web A pplication 
resource "azurerm_linux_web_app" "TaskBoard-alwp" {
  name                = "taskboard-app"
  resource_group_name = azurerm_resource_group.TaskBoard-rg.name
  location            = azurerm_resource_group.TaskBoard-rg.location
  service_plan_id     = azurerm_service_plan.TaskBoard-asp.id

  site_config {
    application_stack {
      dotnet_version = "6.0"
    }
    always_on = false
  }
  connection_string {
    name  = "DefaultConnection"
    type  = "SQLAzure"
    value = "Data Source=tcp:${azurerm_mssql_server.TaskBoard-db-server.fully_qualified_domain_name},1433;Initial Catalog=${azurerm_mssql_database.TaskBoard-db.name};User ID=${azurerm_mssql_server.TaskBoard-db-server.administrator_login};Password=${azurerm_mssql_server.TaskBoard-db-server.administrator_login_password};Trusted_Connection=False; MultipleActiveResultSets=True;"
  }
}

#add GitHub repo as source control
resource "azurerm_app_service_source_control" "app-source" {
  app_id   = azurerm_linux_web_app.TaskBoard-alwp.id
  repo_url = "https://github.com/dimosoftuni/Azure-Web-App-with-Database-Taskboard"
  branch   = "main"
  #use this setting if source control is not in your control
  use_manual_integration = true
}

#add MSSQL server
resource "azurerm_mssql_server" "TaskBoard-db-server" {
  name                         = "taskboard-sqlserver"
  resource_group_name          = azurerm_resource_group.TaskBoard-rg.name
  location                     = azurerm_resource_group.TaskBoard-rg.location
  version                      = "12.0"
  administrator_login          = "4dm1n157r470r"
  administrator_login_password = "4-v3ry-53cr37-p455w0rd"
}

#add MSSQL database
resource "azurerm_mssql_database" "TaskBoard-db" {
  name           = "taskboard-db"
  server_id      = azurerm_mssql_server.TaskBoard-db-server.id
  collation      = "SQL_Latin1_General_CP1_CI_AS"
  license_type   = "LicenseIncluded"
  max_size_gb    = 2
  sku_name       = "Basic"
  zone_redundant = false

  # prevent the possibility of accidental data loss
  #lifecycle {
  #  prevent_destroy = true
  #}
}

#add firewall rule
resource "azurerm_mssql_firewall_rule" "fw" {
  name             = "TaskBoardFirewall"
  server_id        = azurerm_mssql_server.TaskBoard-db-server.id
  start_ip_address = "0.0.0.0"
  end_ip_address   = "0.0.0.0"
}


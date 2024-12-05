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
resource "azurerm_resource_group" "app-rg" {
  location = "West Europe"
  name     = "ContactsBook-${random_integer.ri.result}"
}

#add service plan
resource "azurerm_service_plan" "app-asp" {
  name                = "contact-book-service-plan-${random_integer.ri.result}"
  resource_group_name = azurerm_resource_group.app-rg.name
  location            = azurerm_resource_group.app-rg.location
  os_type             = "Linux"
  sku_name            = "F1"
}

#add azure linux Web A pplication 
resource "azurerm_linux_web_app" "app-alwp" {
  name                = "contact-book-app"
  resource_group_name = azurerm_resource_group.app-rg.name
  location            = azurerm_resource_group.app-rg.location
  service_plan_id     = azurerm_service_plan.app-asp.id

  site_config {
    application_stack {
      node_version = "16-lts"
    }
    always_on = false
  }
}

#add GitHub repo as source control
resource "azurerm_app_service_source_control" "app-source" {
  app_id   = azurerm_linux_web_app.app-alwp.id
  repo_url = "https://github.com/nakov/ContactBook"
  branch   = "master"
  #use this setting if source control is not in your control
  use_manual_integration = true
}



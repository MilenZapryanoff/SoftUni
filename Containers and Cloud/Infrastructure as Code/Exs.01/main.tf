terraform {
	required_providers {
		azurerm = {
			source = "hashicorp/azurerm"
			version = "4.11.0"
		}
	}
}


provider "azurerm" {
	subscription_id = "6a552c94-0736-402d-b8eb-ff288478ee38"
	features {
			}
}


resource "azurerm_resource_group" "resourcegroup_name" {
	location = "West Europe"
	name = "ResourceGroupTerraform"
}

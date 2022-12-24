import { Component, OnInit } from '@angular/core';
import {Pet} from "./pet";
import {HttpErrorResponse} from "@angular/common/http";
import {PetService} from "./pet.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent implements OnInit{
  // title = 'petsmanagerapp';
	public pets: Pet[];

	constructor(private petServices: PetService){}

	ngOnInit(): void {
		this.getPets();
	}

	public getPets(): void {
		this.petServices.getPets().subscribe(
			(response: Pet[]) => {
				this.pets = response;
			},
			(error:HttpErrorResponse) => {
				alert(error.message)
			}
		)
	}
}


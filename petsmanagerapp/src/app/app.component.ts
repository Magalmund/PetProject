import {Component, OnInit} from '@angular/core';
import {Color, Country, Pet, Type} from "./pet";
import {HttpErrorResponse} from "@angular/common/http";
import {PetService} from "./pet.service";
import {FormControl, FormGroup, FormGroupDirective, Validators} from "@angular/forms";
import {RegexNameValidator, RegexName, RegexCodeValidator, RegexCode} from "./regex.validator";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent implements OnInit {
  public pets: Pet[];
  public colors: Color[];
  public countries: Country[];
  public types: Type[];
  public editPet: Pet;
  reactiveForm: FormGroup;

  constructor(private petServices: PetService) {
  }

  ngOnInit(): void {
    this.getPets();
    this.getColors();
    this.getCountries();
    this.getTypes();

    this.reactiveForm = new FormGroup({
      id: new FormControl(),
      petName: new FormControl(null, [Validators.required, RegexNameValidator(RegexName.NAME_REGEX), Validators.minLength(3), Validators.maxLength(15)]),
      petCode: new FormControl(null, [Validators.required, RegexCodeValidator(RegexCode.CODE_REGEX), Validators.minLength(12), Validators.maxLength(12)]),
      type: new FormControl(null, Validators.required),
      color: new FormControl(null, Validators.required),
      country: new FormControl(null, Validators.required)
    })
  }

  /*SELECTOR FIELD VALIDATION*/
  // changeType(e) {
  //   console.log(e.value)
  //   this.reactiveForm.get("type").setValue(e.target.value, {
  //     onlySelf: true
  //   })
  // }

  // CountryOptions = {
  //   default: 'Choose...',
  //   latvia: 'Latvia',
  //   estonia: 'Estonia',
  //   finland: 'Finland'
  // };
  // selectedCountry = this.CountryOptions.default
  /*SELECTOR FIELD VALIDATION END*/

  public getPets(): void {
    this.petServices.getPets().subscribe(
      (response: Pet[]) => {
        this.pets = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message)
      }
    );
  }

  public getColors(): void {
    this.petServices.getColors().subscribe(
      (response: Color[]) => {
        this.colors = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message)
      }
    );
  }

  public getCountries(): void {
    this.petServices.getCountries().subscribe(
      (response: Country[]) => {
        this.countries = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message)
      }
    );
  }

  public getTypes(): void {
    this.petServices.getTypes().subscribe(
      (response: Type[]) => {
        this.types = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message)
      }
    );
  }

  public onAddPet(addForm: FormGroupDirective): void {
    document.getElementById('add-pet-form').click();
    this.petServices.addPet(addForm.value).subscribe(
      (response: Pet) => {
        this.getPets();
        addForm.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    );
  }

  public onUpdatePet(pet: Pet): void {
    document.getElementById('edit-pet-form').click();
    this.petServices.updatePet(pet).subscribe(
      (response: Pet) => {
        this.getPets();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onOpenModal(pet: Pet, mode: string): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-bs-toggle', 'modal');
    if (mode === 'add') {
      button.setAttribute('data-bs-target', '#addPetModal');
      Object.keys(this.reactiveForm.controls).forEach((key: string) => {
        this.reactiveForm.get(key).setValue(null);
      })
    }
    if (mode === 'edit') {
      this.editPet = pet;

      Object.keys(this.reactiveForm.controls).forEach((key: string) => {
        this.reactiveForm.get(key).setValue(this.editPet[key]);
      })
      button.setAttribute('data-bs-target', '#updatePetModal');
    }
    container!.appendChild(button);
    button.click();
  }



}


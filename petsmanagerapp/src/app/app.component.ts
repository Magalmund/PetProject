import {Component, OnInit} from '@angular/core';
import {Pet} from "./pet";
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
  public editPet: Pet;
  reactiveForm: FormGroup;

  constructor(private petServices: PetService) {
  }

  /*TYPE VALIDATOR*/
  Type: any = ['Cat', 'Dog', 'Horse', 'Rabbit', 'Parrot']

  /*TYPE VALIDATOR END*/

  ngOnInit(): void {
    this.getPets();

    this.reactiveForm = new FormGroup({
      petName: new FormControl(null, [Validators.required, RegexNameValidator(RegexName.NAME_REGEX), Validators.minLength(3), Validators.maxLength(15)]),
      petCode: new FormControl(null, [Validators.required, RegexCodeValidator(RegexCode.CODE_REGEX), Validators.minLength(12), Validators.maxLength(12)]),
      type: new FormControl(null, Validators.required),
      color: new FormControl(null, Validators.required),
      country: new FormControl(null, Validators.required)
    })
  }

  /*SELECTOR FIELD VALIDATION*/
  changeType(e) {
    console.log(e.value)
    this.reactiveForm.get('type').setValue(e.target.value, {
      onlySelf: true
    })
  }

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

  public onAddPet(addForm: FormGroupDirective): void {

    console.log(this.reactiveForm);

    document.getElementById('add-pet-form').click();
    this.petServices.addPet(addForm.value).subscribe(
      (response: Pet) => {
        console.log(response);
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
        console.log(response);
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
    }
    if (mode === 'edit') {
      this.editPet = pet;

      // Object.keys(this.reactiveForm.controls).forEach((key: string) => {
      //   this.reactiveForm.get[key].setValue(this.editPet[key]);
      // })
      this.reactiveForm.get('petName').setValue(this.editPet.petName);
      this.reactiveForm.get('petCode').setValue(this.editPet.petCode);
      this.reactiveForm.get('type').setValue(this.editPet.type);
      this.reactiveForm.get('color').setValue(this.editPet.color);
      this.reactiveForm.get('country').setValue(this.editPet.country);
      button.setAttribute('data-bs-target', '#updatePetModal');
    }
    container!.appendChild(button);
    button.click();
  }
}


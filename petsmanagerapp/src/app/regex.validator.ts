import { AbstractControl, ValidatorFn, ValidationErrors } from "@angular/forms";

export class RegexName {
  public static NAME_REGEX = /^[A-Z]+([a-zA-Z]+)+$/;
}

export class RegexCode {
  public static CODE_REGEX = /^[0-9]*$/;
}

export function RegexNameValidator(reg: RegexName): ValidatorFn {
  return (control: AbstractControl): ValidationErrors | null => {
    if (control.value && !control.value.toString().match(reg)) {
      return { petName: true };
    }
    return null;
  };
}

export function RegexCodeValidator(reg: RegexCode): ValidatorFn {
  return (control: AbstractControl): ValidationErrors | null => {
    if (control.value && !control.value.toString().match(reg)) {
      return { petCode: true };
    }
    return null;
  };
}

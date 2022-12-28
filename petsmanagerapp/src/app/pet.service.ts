import {HttpClient} from "@angular/common/http";
import {Injectable} from "@angular/core";
import {Observable} from 'rxjs';
import {Color, Country, Pet, Type} from './pet';
import {environment} from "./environments/environment";

@Injectable({
  providedIn: 'root'
})
export class PetService {
  private apiServerUrl = environment.apiBaseURL;

  constructor(private http: HttpClient) { }

  public getPets(): Observable<Pet[]> {
    return this.http.get<Pet[]>(`${this.apiServerUrl}/pet/all`)
  }

  public addPet(pet: Pet): Observable<Pet> {
    return this.http.post<Pet>(`${this.apiServerUrl}/pet/add`, pet);
  }

  public updatePet(pet: Pet): Observable<Pet> {
    return this.http.put<Pet>(`${this.apiServerUrl}/pet/update`, pet);
  }

  public getColors(): Observable<Color[]>{
    return this.http.get<Color[]>(`${this.apiServerUrl}/color/all`)
  }

  public getTypes(): Observable<Type[]>{
    return this.http.get<Type[]>(`${this.apiServerUrl}/type/all`)
  }

  public getCountries(): Observable<Country[]>{
    return this.http.get<Country[]>(`${this.apiServerUrl}/country/all`)
  }
}

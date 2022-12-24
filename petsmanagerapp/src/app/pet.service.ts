import {HttpClient} from "@angular/common/http";
import {Injectable} from "@angular/core";
import {Observable} from 'rxjs';
import {Pet} from './pet';
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

  public deletePet(petId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/pet/delete/${petId}`);
  }
}

import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, tap } from 'rxjs';
import { ApiRequest } from '../Model/ApiRequest.model';
import { ApiResponse, ChatBotResponse } from '../Model/ChatBotResponse.model';

@Injectable({
  providedIn: 'root'
})
export class ChatgptserviceService {

  constructor(private http: HttpClient) { }
 /* public getChatgpt(request: ApiRequest): Observable<ApiResponse> {
    return this.http.post<ApiResponse>('http://localhost:9000/api/v1/ai/request', request);
  }*/

/*public getChatgpt(request: ApiRequest): Observable<ChatBotResponse> {
  return this.http.post<ChatBotResponse>('http://localhost:9000/api/v1/ai/request', request);
}*/

public getChatgpt(request: ApiRequest): Observable<ApiResponse> {
  console.log('Sending request:', request);

  return this.http.post<ApiResponse>('http://localhost:9000/api/v1/ai/request', request).pipe(
    tap(response => console.log('Received response:', response)),
    catchError(error => {
      console.error('Error in request:', error);
      throw error;
    })
  );
}

}

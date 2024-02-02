import { Component, OnInit } from '@angular/core';
import { ChatgptserviceService } from '../services/chatgptservice.service';
import { ApiRequest } from '../Model/ApiRequest.model';
import { ApiResponse, ChatBotResponse, ChatHistory } from '../Model/ChatBotResponse.model';

@Component({
  selector: 'app-chatboot',
  templateUrl: './chatboot.component.html',
  styleUrls: ['./chatboot.component.css']
})
export class ChatbootComponent implements OnInit {
  public keyword: string = '';
  

  public chatBotResponse: ApiResponse | undefined;

  public responseHistory: ChatHistory[] = [];

  constructor(private chatgptservice: ChatgptserviceService) { }

  ngOnInit(): void { }

  public getChatbot(): void {
    console.log("ok")
    if (this.keyword.trim() !== '') {
      
      const request: ApiRequest = {
        message: this.keyword

      };

      
     
      this.chatgptservice.getChatgpt(request).subscribe({
        next: (response) => {
          this.chatBotResponse = response;
          this.responseHistory.push({ message: this.keyword, response:this.chatBotResponse });
          
      
        },
        error: (error) => {
          console.error('Erreur Angular :', error);
        }
      });
      
    }
  }
  
  public downloadJavaFile(): void {
    if (this.chatBotResponse) {
      const blob = new Blob([this.chatBotResponse.response], { type: 'text/plain' });
      const url = window.URL.createObjectURL(blob);
      const a = document.createElement('a');
      a.href = url;
      a.download = 'toncode.java';
      document.body.appendChild(a);
      a.click();
      document.body.removeChild(a);
      window.URL.revokeObjectURL(url);
    }
  }
  
  
}

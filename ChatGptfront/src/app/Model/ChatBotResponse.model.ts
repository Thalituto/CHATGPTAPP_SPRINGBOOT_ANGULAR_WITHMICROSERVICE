export interface ChatBotResponse {
    id: string;
    choices: Choice[];
  }
  
  export interface Choice {
    index: number;
    message: Message;
  }
  
  export interface Message {
    role: string;
    content: string;
  }
  
  export interface ApiResponse {
    response: string;
  }

  export interface ChatHistory {
    message: string;
    response: ApiResponse;
  }
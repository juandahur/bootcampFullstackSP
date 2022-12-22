import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ClientsService } from 'src/app/shared/services/clients.service';


@Component({
  selector: 'app-clients-create',
  templateUrl: './clients-create.component.html',
  styleUrls: ['./clients-create.component.css']
})
export class ClientsCreateComponent implements OnInit {

  @Input() clientDetails = { 
    idDocument: '',
    idNumber: '',
    firstName: '',
    lastName: '',
    email: '',
    birthDate: '',
    
  };

  listIDTypes: string[] = ['CC','CE'];



  constructor(public serviceClients: ClientsService, public router: Router) {}

  ngOnInit() {}
  addClient(dataClient: any) {
    this.serviceClients.createClient(this.clientDetails).subscribe((data: {}) => {
      this.router.navigate(['/clients']);
    });
  }
  
  
  }


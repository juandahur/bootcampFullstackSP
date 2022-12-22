import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ClientsService } from 'src/app/shared/services/clients.service';

@Component({
  selector: 'app-clients-edit',
  templateUrl: './clients-edit.component.html',
  styleUrls: ['./clients-edit.component.css']
})
export class ClientsEditComponent implements OnInit{

  id = this.actRoute.snapshot.params['id'];
  clientData: any = {};
  listIDTypes: string[] = ['CC','CE'];

  constructor(
    public serviceClients: ClientsService,
    public actRoute: ActivatedRoute,
    public router: Router
  ) { 
  }
  ngOnInit() { 
    this.serviceClients.getClient(this.id).subscribe((data: {}) => {
      this.clientData = data;
    })
  }
  // Update employee data
  updateClient() {
    if(window.confirm('Are you sure, you want to update?')){
      this.serviceClients.updateClient(this.id, this.clientData).subscribe(data => {
        this.router.navigate(['/clients'])
      })
    }
  }
}

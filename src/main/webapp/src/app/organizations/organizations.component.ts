import { Component, OnInit } from '@angular/core';
import {Restangular} from "ngx-restangular";

@Component({
  selector: 'app-org',
  templateUrl: './organizations.component.html',
  styleUrls: ['./organizations.component.css']
})

export class OrganizationsComponent implements OnInit {
  organizations;
  current;
  data: any = {};

  onSubmit() {
    alert(JSON.stringify(this.data));
  }

  constructor(private restangular: Restangular) { }


  ngOnInit() {
    this.current = {
      name: "",
      info: "",
      address: "",
      telephone: "",
      countEmployees: 0
    };

    this.getAll();
  }

  onSelect(id){
    this.restangular.one("organizations", id).get().subscribe(response => {
      this.current = response;
    });
  }

  getAll(){
    let orgList = this.restangular.all('organizations');
    orgList.getList().subscribe(response => {
      this.organizations = response;
    });

  }

  add(){

      let newOrg = {
        name: this.current.name,
        info: this.current.info,
        address: this.current.address,
        telephone: this.current.telephone,
        countEmployees: this.current.countEmployees

      };

      this.restangular.all('organizations').post(newOrg).subscribe(response =>{
        this.getAll();
      });

  }

  delete(id){

    let deletedOrg = this.restangular.one('organizations', id);
    deletedOrg.remove().subscribe(response => {
      this.getAll();
      this.current = {
        name: "",
        info: "",
        address: "",
        telephone: "",
        countEmployees: 0
      };
    });

  }

  update(invalidName){

    if(!invalidName){
      this.current.save().subscribe(response => {
        this.getAll();
      });
    }

  }

}

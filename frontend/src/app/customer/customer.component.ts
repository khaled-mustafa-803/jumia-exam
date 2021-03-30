import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { environment } from 'src/environments/environment';



@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {

  constructor(private httpClient: HttpClient) { }
  customerList=[];
  page_num: number = 0;
  page_size=10;
  total;
  name;
  country;
  ngOnInit() {
    let parameters = new HttpParams();
    parameters= parameters.set('page',this.page_num+"");
    parameters= parameters.set('size',this.page_size+"");
    
this.getCustomers(parameters);
  }
  callListCustomers(param?){
    let  header=new HttpHeaders();
    header=header.set('Access-Control-Allow-Origin','*');
    
    return this.httpClient.get(`${environment.base_url}customer`, {params:param, headers:header});
  }
  getCustomers(param?)
  {
    this.callListCustomers(param).subscribe(res=>
      {
        this.customerList=res['content'];
        this.total=res['totalElements']
        
      })
  }
  filter(name,country)
  {

    let parameters = new HttpParams();
    this.name=name;
    this.country=country;
    this.page_num = 0;
    

      if(this.name){
        parameters= parameters.set('name',name+"");
      }
      if(this.country){
        parameters= parameters.set('country',country+"");
      }
      parameters= parameters.set('page',this.page_num+"");
      parameters= parameters.set('size',this.page_size+"");


      this.getCustomers(parameters);
  
    
    
  }
  paging($event)
  {
    let parameters = new HttpParams();

    this.page_num=$event -1;
    if(this.name){
      parameters= parameters.set('name',this.name+"");
    }
    if(this.country){
      parameters= parameters.set('country',this.country+"");
    }
    if(this.page_num)
    parameters= parameters.set('page',this.page_num+"");
    if(this.page_size)
    parameters= parameters.set('size',this.page_size+"");

    this.getCustomers(parameters);
    
  }

}

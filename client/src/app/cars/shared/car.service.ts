import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions, RequestMethod } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/toPromise';
import {Car} from './car.model'



@Injectable()
export class CarService {
selectedCar : Car;
carList : Car[];
constructor(private http : Http) { }

  postCar(c : Car){
    var body = JSON.stringify(c);
    var headerOptions = new Headers({'Content-Type':'application/json'});
    var requestOptions = new RequestOptions({method : RequestMethod.Post,headers : headerOptions});
    return this.http.post('http://localhost:8080/Users',body,requestOptions).map((response: Response) => response)
  }

  putCar(id, c){
    var body = JSON.stringify(c);
    var headerOptions = new Headers({'Content-Type':'application/json'});
    var requestOptions = new RequestOptions({method : RequestMethod.Put,headers : headerOptions});
    return this.http.put('http://localhost:8080/Users/' + id ,body,requestOptions).map((response: Response) => response)
  }

  getCarList(){
    this.http.get('http://localhost:8080/Users')
    .map ((data: Response)=> {
      return data.json() as Car[];
    }).toPromise().then(x => {
      this.carList = x;
    })
  }


  deleteCar(id: number) {
    return this.http.delete('http://localhost:8080/Users/' + id).map(res => res);
  }

}

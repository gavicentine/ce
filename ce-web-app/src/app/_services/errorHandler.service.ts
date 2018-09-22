import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';

@Injectable()
export class ErrorHandlerService {
  constructor() {}

  // catchs the error that is supposed to be at response message
  handleError(error: any) {
    const appError = error.headers.get('Application-Error');
    if (appError) {
      return Observable.throw(appError);
    }

    const serverError = error.json();
    let modelStateError = '';
    if (serverError) {
      for (const key in serverError) {
        if (serverError[key]) {
          modelStateError += serverError[key] + '\n';
        }
      }
    }
    return Observable.throw(modelStateError) || 'Server Error';
  }
}

import { Injectable } from '@angular/core';

declare let alertify: any;

@Injectable()
export class MessageService {

  public SALVO_SUCESSO = 'Registro salvo com sucesso.';

  constructor() {
    // alertify.set('notifier', 'position', 'top-center');
  }

  confirm(message: string, okCallback: () => any) {
    alertify.confirm(message, function(e) {
      if (e) {
        okCallback();
      } else {
      }
    });
  }

  success(message: string) {
    alertify.success(message);
  }

  error(message: string) {
    alertify.error(message);
  }

  message(message: string) {
    alertify.message(message);
  }
}

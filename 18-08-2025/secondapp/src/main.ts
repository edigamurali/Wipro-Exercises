import { bootstrapApplication } from '@angular/platform-browser';
import { appConfig } from './app/app.config';
import { App } from './app/app';
import { ListCompt } from './app/list-compt/list-compt';
import { Country } from './app/country/country';
import { Listbox } from './app/listbox/listbox';
import { Exe15booklist } from './app/exe15booklist/exe15booklist';

bootstrapApplication(Exe15booklist, appConfig).catch((err) => console.error(err));

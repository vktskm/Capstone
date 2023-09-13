import { Icity } from './Icity';
import { Iristorante } from './Iristorante';
import { Ispiaggia } from './Ispiaggia';

export interface Iprenota {
  idPrenotazione?: number;
	viaggi?: Icity[];
	spiaggia?: Ispiaggia[];
  ristorante?: Iristorante[];
	pagata?: boolean;
	utente?: number;
}

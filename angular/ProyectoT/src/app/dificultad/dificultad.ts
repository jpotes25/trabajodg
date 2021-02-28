import {Multimedia} from '../multimediadif/multimedia';
import {Actividades} from '../actividades/actividades';
import {Referentes} from '../referentes/referentes';
export class Dificultad {
  idDificultad: number;
  nombreDificultad: string;
  queEs: string;
  comoIdentificarlo: string;
  enlaceSlider: string;
  multimedia: Multimedia[];
  actividad: Actividades[];
  referente: Referentes[];
}

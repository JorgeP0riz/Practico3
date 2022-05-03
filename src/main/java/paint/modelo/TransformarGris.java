package paint.modelo;

public class TransformarGris extends Transformar{
    public TransformarGris(Imagen img) {
        this.imagen = img;
    }
    @Override
    public void transformar() {
        int[][] pixeles = imagen.getPixeles();
        for (int i = 0; i < imagen.getAncho(); i++) { //imagen.getAncho()
            for (int j = 0; j < imagen.getAlto(); j++) {//imagen.getAlto()
                int c = pixeles[i][j];

                int r = (c >> 16);//16
                int g = (c >> 8) & 0xff ;//8
                int b = c  & 0xff;

                //int gris = (r + g + b) / 3;
                int gris = (int)(((double)r + (double)g + (double)b) / 3.0);

                //int intGris = gris & (gris << 8) & (gris << 16);
                int intGris=gris + gris * 256 + gris * 256 * 256;//256;

                imagen.setColor(intGris,i, j);
            }
        }
        imagen.transformada();
    }
}

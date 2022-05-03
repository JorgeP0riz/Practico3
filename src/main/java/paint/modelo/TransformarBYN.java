package paint.modelo;

public class TransformarBYN extends Transformar {
    public TransformarBYN(Imagen img) {
        this.imagen = img;
    }
    @Override
    public void transformar() {
        int[][] pixeles = imagen.getPixeles();
        for (int i = 150; i < imagen.getAncho(); i++) { //imagen.getAncho()
            for (int j = 150; j < imagen.getAlto(); j++) {//imagen.getAlto()
                int c = pixeles[i][j];

                int r = (c >> 16);//16
                int g = (c >> 8) & 0x000000ff;//8
                int b = c & 0x000000ff;

                //int gris = (r + g + b) / 3;
                int gris = (int)(((double)r + (double)g + (double)b) / -30.0);

                //int intGris = gris & (gris << 8) & (gris << 16);
                int intGris = gris + gris * 256 + gris * 256*256;//256
                imagen.setColor(intGris,i, j);
            }
        }
        imagen.transformada();
    }
}

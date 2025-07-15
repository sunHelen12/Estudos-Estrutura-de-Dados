package models;

public class ArvoreBinariaBusca <T>{
    private NoTriplo<T> raiz;
    private int quantidade;


    // Localizar Nó por ID
    public NoTriplo[] localizarNo(int id){
        NoTriplo[] noa = new NoTriplo[2]; // Vetor de retorno
        noa[1] = raiz;

        while(true){
            if(noa[1] == null || noa[1].getId() == id){
                return noa; // Se o id com o nó for encontrado, retorna-se esse id
            }
            noa[0] = noa[1]; // Nó analisado passa a condição de pai

            if(id < noa [0].getId()){
                noa[1] = noa[0].getEsq(); // Se o id for menor - vamos para o lado esquerdo
            }else{
                noa[1] = noa[0].getDir(); // Se o id for maior - vamos para o lado direito
            }
        }
    }

    public boolean inserir(NoTriplo no){
        if (raiz == null){
            raiz = no;
            quantidade = 1; // Se a raíz for null, o dado será adicionado a ela
            return true;
        }

        NoTriplo cursor = raiz;

        while (true){
            if(no.getId() == cursor.getId()){
                return false;
            }

            if(no.getId() < cursor.getId()) {
                if (cursor.getEsq() == null) {
                    cursor.setEsq(no);
                    quantidade++;     // Se for menor que o ponteiro marcado para no id, ela vao para o lado esq.
                    return true;       // Quando encontrar um nó vazio, ele será setado como esse nó
                }
                cursor = cursor.getEsq();
                continue;
            }

            if(no.getId() > cursor.getId()){
                if (cursor.getDir() == null){
                    cursor.setDir(no);
                    quantidade++;
                    return true;
                }

                cursor = cursor.getDir();
                continue;
            }
        }

    }

    public NoTriplo extrair (int id){
        if (quantidade == 0){
            return null; // Caso a Árvore esteja vazia
        }

        if(quantidade == 1 && id == raiz.getId()){
            NoTriplo no = raiz;
            raiz = null;
            quantidade = 0;
            return no;
        }

        NoTriplo [] noa = localizarNo(id);

        if(noa[1] == null){
            return null;
        }

        NoTriplo noPai = noa[0]; // Nó pai para ser extraído
        NoTriplo noId = noa[1]; // Nó que é para ser extraído

        // Filhos do nó a ser extraído
        NoTriplo filhoIdEsq = noId.getEsq();
        NoTriplo filhoIdDir = noId.getDir();

        // Quando o nó não tem filhos (é um nó folha)
        if(filhoIdEsq == null && filhoIdDir == null){
            if(noId.getId() < noPai.getId()){
                noPai.setEsq(null);
            } else{
                noPai.setDir(null);
            }
        }

        // Quando o nó apenas 1 filho
        else if (filhoIdEsq == null && filhoIdDir == null
                || filhoIdEsq != null && filhoIdDir == null) {
            // Quando o nó removido for a raíz (não ter pai)
            if(noId == raiz){
                if(filhoIdEsq != null){
                    raiz = filhoIdEsq;
                } else {
                    raiz = filhoIdDir;
                }
            // Nó removido que não seja a raíz
            } else{
                if (noId.getId() > noPai.getId()){ // Quando o nó extraído é filho à direita
                    if (filhoIdEsq != null){
                        noPai.setDir(filhoIdEsq);
                    }else{
                        noPai.setDir(filhoIdDir);
                    }
                }
            }
        // Quando o nó tem os dois filhos
        }else if (filhoIdEsq != null && filhoIdDir != null){
            // Quando o nó é a raíz
            if (noId == raiz){
                NoTriplo[] noaE = maiorValorSubEsq(raiz);
                NoTriplo[] noaD = maiorValorSubDir(raiz);

                NoTriplo[] noaSubst; // Nó substituto; Eleger o nó do lado mínimo ou máximo estão mais distantes
                                    // da raíz
            }
        }

    }

}

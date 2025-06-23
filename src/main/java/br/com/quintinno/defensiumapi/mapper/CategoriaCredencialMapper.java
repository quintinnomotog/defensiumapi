package br.com.quintinno.defensiumapi.mapper;

import java.util.List;

import br.com.quintinno.defensiumapi.entity.CategoriaCredencialEntity;
import br.com.quintinno.defensiumapi.tranfer.CategoriaCredencialRequestTransfer;
import br.com.quintinno.defensiumapi.tranfer.CategoriaCredencialResponseTransfer;
import br.com.quintinno.defensiumapi.utility.DateUtility;

public class CategoriaCredencialMapper {

    public static CategoriaCredencialEntity toCategoriaCredencialEntity(
            CategoriaCredencialRequestTransfer categoriaCredencialRequestTransfer) {
        return new CategoriaCredencialEntity(
                categoriaCredencialRequestTransfer.getDescricao(),
                DateUtility.getDataHora());
    }

    public static List<CategoriaCredencialResponseTransfer> toCategoriaCredencialResponseTransfer(
            List<CategoriaCredencialEntity> categoriaCredencialList) {
        return categoriaCredencialList.stream().map(CategoriaCredencialMapper::fromCategoriaCredencialResponseTransfer)
                .toList();
    }

    public static CategoriaCredencialResponseTransfer fromCategoriaCredencialResponseTransfer(
            CategoriaCredencialEntity categoriaCredencialEntity) {
        CategoriaCredencialResponseTransfer categoriaCredencialResponseTransfer = new CategoriaCredencialResponseTransfer();
            categoriaCredencialResponseTransfer.setCodePublic(categoriaCredencialEntity.getCodePublic());
            categoriaCredencialResponseTransfer.setDescricao(categoriaCredencialEntity.getDescricao());
        return categoriaCredencialResponseTransfer;
    }

}

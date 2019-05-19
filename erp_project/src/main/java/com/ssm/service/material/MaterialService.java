package com.ssm.service.material;

import com.ssm.bean.material.Material;
import com.ssm.bean.material.MaterialReceive;
import org.springframework.stereotype.Service;

import java.util.List;

public interface MaterialService {
    public List findList(int page, int rows);


     int findCount();

    int insertMaterial(Material material);

    Material selectMaterialById(String materialId);

    List findAllMaterialList();
}

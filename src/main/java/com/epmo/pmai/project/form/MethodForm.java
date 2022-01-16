package com.epmo.pmai.project.form;

import com.epmo.pmai.product.Product;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.OneToMany;
import java.util.Set;

@Data
@RequiredArgsConstructor
public class MethodForm {
    //////////4. 사업추진방법
    //업체선정 방법
    private String selectionMethod;

    private Boolean emergency;

    private String emergencyBackground;

    //소요시간
    private String duration;

    //협조부서
    private String cooperationDepartment;

    private String totalAmount;
}

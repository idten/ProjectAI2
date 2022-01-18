package com.epmo.pmai.project.form;

import com.epmo.pmai.product.Product;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Data
@RequiredArgsConstructor
public class ContentsForm {

    //////3. 사업 내용 ///////
    //추진배경(객관식)
    private String background;

    //추진배경(상세)
    private String backgroundDetail;

    // 자본 총합
    private String capitalTotalAmount;

    // 경비 총합
    private String expenseTotalAmount;

    // 자본 총합
    private String totalAmount;


    //도입내역
    @OneToMany
    private Set<Product> products;


}

package com.zsw.common.model.dto.order;

import com.zsw.common.common.PageRequest;
import lombok.Data;

import java.io.Serializable;


@Data
public class OrderQueryRequest extends PageRequest implements Serializable {
    private String type;
}

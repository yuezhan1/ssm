package pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Record implements Serializable {
    private Integer id;

    private Date time;

    private Float amount;

    private String sourceAccount;

    private String targetAccount;

    private static final long serialVersionUID = 1L;

}

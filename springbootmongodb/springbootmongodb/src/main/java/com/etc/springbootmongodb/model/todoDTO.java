package com.etc.springbootmongodb.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "notification_inbox_collection")
public class todoDTO {

    @Id
    private String userId;

    @NotNull(message = "notiMsg cannot be notnull")
    private String notiMsg;

    private Date receiverTime;

    private Date changeTime;

    @Min(0)
    @Max(1)
    @NotNull(message = "status cannot be notnull")
    private Integer status;

}

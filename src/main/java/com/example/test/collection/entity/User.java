package com.example.test.collection.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Package: com.example.test.collection.entity
 * @Author: Mr.Waves
 * @Date: 2020-04-20 14:11
 * @Description:
 **/

@Data  //@Data相当于@Getter @Setter @RequiredArgsConstructor @ToString @EqualsAndHashCode
@AllArgsConstructor
public class User {
    private Long id;
    private String name;
}

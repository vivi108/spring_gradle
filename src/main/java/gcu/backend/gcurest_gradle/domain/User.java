package gcu.backend.gcurest_gradle.domain;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column; //회사 이름 바뀜..
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Component
@Entity
@Table(name="user")
public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name="id")
   private Integer id;

   @Column(name="brand")
   private String brand;
   @Column(name="company")
   private String company;

   @Column(name="price")
   private Integer price;


   @Builder
   public User (Integer id, String brand, String company, Integer price){
      this.id=id;
      this.brand = brand;
      this.company = company;
      this.price =price;
   }

}
package com.akbank.springbootaop.aspects;

import java.util.Arrays;

import org.apache.logging.log4j.util.Strings;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {

  // @Before(value = "execution(* com.akbank.springbootaop..*(..))") // methoda
  // girmeden önce buradaki kod blogu tetiklenir
  @Before(value = "@annotation(Log)")
  public void logBefore(JoinPoint joinPoint) {
    System.out.println(Arrays.toString(joinPoint.getArgs()));
  }

  // uygulama dizini altındaki tüm methodlara bunu uygular.
  // execute ile uygulama dizini altındaki bir sınıfa ait nokta atışı method ismi
  // yazılabilir.
  // @After(value = "execution(* com.akbank.springbootaop..*(..))") methoddan
  // çıktan sonra çalışan aspect
  // @After(value = "execution(* com.akbank.springbootaop..*(..))")
  // *.*.* uygulama dizininde her bir klasör altındaki herhangi bir dosya
  // aşağıdaki gibni uygulama genelinde tanımlama yapmak yönetim açısında
  // risklidir.
  // @After("execution(* com.akbank.springbootaop.*.*.*(..))")
  // servises klasörü altına bak
  // @After("execution(* com.akbank.springbootaop.services.*.*(..))")
  // genel kullanım projede referansı bulunan herhangi bir anotasyon isminden
  // bu çağırma işlemine pointcut ismi veriyoruz
  @After(value = "@annotation(Log))")
  public void logAfter(JoinPoint joinPoint) {
    System.out.println("After Log" + Arrays.toString(joinPoint.getArgs()));
    // System.out.println(String.format("name=%s desc=%s", name, description));

  }

  // Öncesinde girdim
  // sonrasında araya gitip buradaki try catch kod blogunu çalıştırıdm
  // sonrasında ise işlemi bitirdim
  // joinPoint ilk olarak before işlemindeki pointler verir null gelir
  // after kısmında işlenirken after sürecisinde değikenin değişen kısımlarını
  // almalıyız.
  @Around(value = "@annotation(Log)")
  public String logAround(ProceedingJoinPoint joinPoint) throws Throwable {
    // kod blogunda hata olabilme durumu düşünülerek thowable olarak yazılmıştır

    // Before kısmı
    System.out.println("Around1" + Arrays.toString(joinPoint.getArgs()));

    try {

      Object result = joinPoint.proceed(); // bu kod blogundan sonra after geçer.
      // result göre logma
      // methodun dönüş tipine göre joinPoint.proceed() ile sonucu yakalyıp loglamak
      // response görüntüledik.

      // After kısmı
      System.out.println("Around2" + Arrays.toString(joinPoint.getArgs()));

    } catch (Exception e) {
      // TODO: handle exception
    }

    return "AfterAround";
  }

  // bir exception hata oluştuğu durumda devreye girer.
  // afterthrowing after öncesinde method içerisinde bir hata olduğu durumda
  // çalıştı
  // PointCut işlemi => value = "@annotation(Log)"
  @AfterThrowing(value = "@annotation(Log)")
  public void AfterThrowing(JoinPoint joinPoint) {
    System.out.println("AfterThrowing");
  }

  @AfterReturning(value = "@annotation(Log)")
  public void AfterReturning(JoinPoint joinPoint) {
    System.out.println("AfterReturning");
  }

}

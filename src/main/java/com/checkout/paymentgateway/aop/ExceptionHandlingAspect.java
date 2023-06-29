package com.checkout.paymentgateway.aop;

import com.checkout.paymentgateway.exception.PaymentException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExceptionHandlingAspect {

    @Around("execution(* com.checkout.paymentgateway.*.*(..))")
    public Object handleException(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            return joinPoint.proceed();
        } catch (PaymentException ex) {
            // Custom exception handling logic for BankNotFoundException
            // You can log the exception, send notifications, or perform other actions
            // Return an appropriate response or throw a different exception if needed
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
            // Custom exception handling logic for OtherException
            // Handle other exceptions
        }
    }
}
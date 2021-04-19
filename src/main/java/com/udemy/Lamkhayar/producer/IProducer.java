package com.udemy.Lamkhayar.producer;

import com.udemy.Lamkhayar.json.Student;

public interface IProducer {
    void produceMessage(Student student);
}

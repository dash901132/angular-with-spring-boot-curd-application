package com.neosoft.poc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document("employee_state")
public class EmployeeState {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected String id= UUID.randomUUID().toString();

    public String getId() {
        return this.id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeState that = (EmployeeState) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(ename, that.ename) &&
                Objects.equals(lname, that.lname) &&
                Objects.equals(salary, that.salary) &&
                Objects.equals(dept, that.dept);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ename, lname, salary, dept);
    }

    public void setId(String id) {
        this.id = UUID.randomUUID().toString();
    }

    protected String ename;
    protected String lname;
    protected String salary;
    protected String dept;

    @Override
    public String toString() {
        return "EmployeeState{" +
                "id='" + id + '\'' +
                ", ename='" + ename + '\'' +
                ", lname='" + lname + '\'' +
                ", salary='" + salary + '\'' +
                ", dept='" + dept + '\'' +
                '}';
    }
}

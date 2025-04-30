package com.victorxavier.modularmonolith.modules.clientadmin.application.dto;

import java.util.Objects;

public class FindClientInputDto {
    private String id;

    public FindClientInputDto() {}
    public FindClientInputDto(String id) {this.id = id;}

    public String getId() {return id;}
    public void setId(String id) {this.id = id;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FindClientInputDto that = (FindClientInputDto) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "FindClientInputDto{" +
                "id='" + id + '\'' +
                '}';
    }
}

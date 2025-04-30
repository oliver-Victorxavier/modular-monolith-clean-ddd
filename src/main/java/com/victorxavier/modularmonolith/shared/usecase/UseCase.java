package com.victorxavier.modularmonolith.shared.usecase;

public interface UseCase<I, O> {
    O execute(I input);
}
package com.academy.secondo_progetto;

import org.springframework.stereotype.Service;

@Service
public class SalutoIngleseService implements SalutoService
{
    @Override
    public String getSaluto()
    {
        return "Good Morning!";
    }
}

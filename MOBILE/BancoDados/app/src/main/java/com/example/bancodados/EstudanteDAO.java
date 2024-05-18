package com.example.bancodados;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class EstudanteDAO {
    private Database db;

    public EstudanteDAO(Database db) {
        this.db = db;
    }

    public long salvar(Estudante estudante){
        long id = -1;
        SQLiteDatabase dbConexion = db.getWritableDatabase();
        try{
            if(!(estudante.getNome().isEmpty() &&  estudante.getCpf().isEmpty())){
                ContentValues values = new ContentValues();
                values.put("nome", estudante.getNome());
                values.put("cpf", estudante.getCpf());
                id = dbConexion.insert("estudante", null, values);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            dbConexion.close();
        }
        return id;
    }


    @SuppressLint("Range")
    public List<Estudante> listarTodos(){
        SQLiteDatabase dbConexao = db.getReadableDatabase();
        List<Estudante> todos = new ArrayList<>();

        try{
            Cursor cursor = dbConexao.rawQuery("SELECT * FROM estudante", null);

            if(cursor.moveToFirst()){
                while(cursor.moveToNext()) {
                    Estudante e = new Estudante(-1, "", "");
                    e.setId(cursor.getInt(cursor.getColumnIndex("id")));
                    e.setNome(cursor.getString(cursor.getColumnIndex("nome")));
                    e.setCpf(cursor.getString(cursor.getColumnIndex("cpf")));

                    todos.add(e);
                }
                cursor.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            dbConexao.close();
        }
        return todos;
    }
}

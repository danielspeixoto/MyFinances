package com.example.danielspeixoto.meufinanceiro.module;

/**
 * Created by danielspeixoto on 1/6/17.
 */

public class CRUD {

    public static class All {

        public interface View<T> extends Base.View {

            void addItem(T t);

        }

        public interface Presenter<T> extends Base.Presenter {

            void selectAll();

        }
    }

    public static class Select {

        public interface View<T> extends Base.View {

            void fillData(T t);

        }

        public interface Presenter<T> extends Base.Presenter {

            void select(String id);

        }
    }
}

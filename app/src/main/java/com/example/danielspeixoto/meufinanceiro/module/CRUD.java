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

    public static class Delete {

        public interface View<T> extends Base.View {


        }

        public interface Presenter<T> extends Base.Presenter {

            void delete(String id);

        }
    }

    public static class Insert {

        public interface View<T> extends Base.View {


        }

        public interface Presenter<T> extends Base.Presenter {

            void insert(T t);

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

    public static class Update {

        public interface View<T> extends Base.View {


        }

        public interface Presenter<T> extends Base.Presenter {

            void update(T t);

        }
    }
}

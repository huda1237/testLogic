package co.id.test.sales.Constant;

public class QueryConstant {
    public static final String INSERT_GROUP_PRODUCT = "INSERT INTO sales.product_groups( " +
            "group_name , description) " +
            "VALUES (?, ?) RETURNING *; ";

    public static final String SELECT_GROUP_PRODUCT = "SELECT group_id, description, group_name " +
            "FROM sales.product_groups WHERE group_id = ? ";
    public static final String SELECT_GROUP_PRODUCT_ALL = "SELECT group_id, description, group_name " +
            "FROM sales.product_groups";
    public static final String INSERT_PRODUCT = "INSERT INTO sales.products( " +
            "product_name, price, group_id) " +
            "VALUES (?, ? , ?) RETURNING *; ";

    public static final String SELECT_PRODUCT = "SELECT a.product_id, a.product_name, a.price, b.group_name , b.description as description_group " +
            " FROM sales.products a join sales.product_groups b on a.group_id = b.group_id where a.product_id = ? ;";
    public static final String SELECT_PRODUCT_ALL = "SELECT a.product_id, a.product_name, a.price, b.group_name , b.description as description_group " +
            " FROM sales.products a join sales.product_groups b on a.group_id = b.group_id ;";
}

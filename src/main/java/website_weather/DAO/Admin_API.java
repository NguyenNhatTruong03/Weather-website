package website_weather.DAO;

import java.io.IOException;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.MasterNotRunningException;

import org.apache.hadoop.conf.Configuration;

public class Admin_API {

	public static void Create_Table(HBaseAdmin admin, String table_name) throws IOException {

		HTableDescriptor tableDescriptor = new 
				HTableDescriptor(TableName.valueOf(table_name));//table_name = Weather

		tableDescriptor.addFamily(new HColumnDescriptor("Location"));
		tableDescriptor.addFamily(new HColumnDescriptor("Current"));
		tableDescriptor.addFamily(new HColumnDescriptor("curr_Condition"));
		tableDescriptor.addFamily(new HColumnDescriptor("curr_air_quality"));
		

		admin.createTable(tableDescriptor);
		System.out.println(" Table created ");
	}

	public static void Listing_Table(HBaseAdmin admin) throws IOException {
		HTableDescriptor[] tableDescriptor = admin.listTables();

		// printing all the table names.
		for (int i = 0; i < tableDescriptor.length; i++) {
			System.out.println(tableDescriptor[i].getNameAsString());
		}
	}
	//đang lỗi hàng này 
	public static void Disable_Table(HBaseAdmin admin, String table_name) throws MasterNotRunningException, IOException {

	      try {
	    	  admin.disableTable(TableName.valueOf(table_name));
		      System.out.println("Table disabled");
		} catch (Exception e) {
			System.out.println("The table has been disabled");
		}
	}
	public static void Enable_Table(HBaseAdmin admin, String table_name) throws MasterNotRunningException, IOException {

	      try {
	    	  admin.enableTable(TableName.valueOf(table_name));
		      System.out.println("Table enabled");
		} catch (Exception e) {
			System.out.println("The table has been enabled");
		}
	}
	
	public static void Descriptor_Table(HBaseAdmin admin, String table_name) throws IOException {
	      HColumnDescriptor columnDescriptor = 
	    		  new HColumnDescriptor("contactDetails");
	      
	      // Adding column family
	      admin.addColumn(TableName.valueOf(table_name), columnDescriptor);
	      System.out.println("coloumn added");
	}
	public static void Exists_Table(HBaseAdmin admin, String table_name) throws IOException {
	      System.out.println(admin.tableExists(TableName.valueOf(table_name)));
	}
	public static void Drop_Table(HBaseAdmin admin, String table_name) throws IOException {
	      admin.disableTable(TableName.valueOf(table_name));
	      admin.deleteTable(TableName.valueOf(table_name));
	      System.out.println("Table deleted");
	}
	
	/*public static void main(String[] args) throws IOException {
		Configuration conf = HBaseConfiguration.create();
		Connection conn = ConnectionFactory.createConnection(conf);
		HBaseAdmin admin = (HBaseAdmin) conn.getAdmin();
		String table_name = "Weather";

		Create_Table(admin, table_name);
		//Listing_Table(admin);
		//Disable_Table(admin, table_name);
		//Enable_Table(admin, table_name);
		//Descriptor_Table(admin, table_name);
		//Exists_Table(admin, table_name);
		//Drop_Table(admin, table_name);
		conn.close();
	}*/

}

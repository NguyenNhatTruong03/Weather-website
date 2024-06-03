package website_weather.DAO;

import java.io.IOException;

import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Table;

public interface IClient_API {

	ResultScanner Scan_Table_ColumnValueFilterList(String table_name, String column_f1, String column1, String value1, String column_f2,
			String column2, String value2, String value3) throws IOException;

	ResultScanner Scan_Table_SingleColumnValueFilter(String table_name, String column_f, String column, String value) throws IOException;


	Cell[] Read_Data(String table_name, String rowkey) throws IOException;

	void Update_Data(String table_name, String rowkey, String column_f, String column, String value) throws IOException;

	void Put_Data(String table_name, String rowkey, String column_f, String column, String value) throws IOException;

	void Delete_Data(String rowkey) throws IOException;

}

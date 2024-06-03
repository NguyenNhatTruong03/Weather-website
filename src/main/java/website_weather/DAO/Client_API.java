package website_weather.DAO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.CompareOperator;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Delete;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.filter.CompareFilter;
import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.filter.FilterList;
import org.apache.hadoop.hbase.filter.SingleColumnValueFilter;
import org.apache.hadoop.hbase.util.Bytes;

import website_weather.Models.weather_weathers;

public class Client_API implements IClient_API{
	static Configuration config = HBaseConfiguration.create();

	@Override
	public void Put_Data(String table_name, String rowkey, String column_f, String column, String value) throws IOException {
		Connection conn = ConnectionFactory.createConnection(config);
		Table Htable = conn.getTable(TableName.valueOf(table_name));
		Put p = new Put(Bytes.toBytes(rowkey));
		p.addColumn(Bytes.toBytes(column_f), Bytes.toBytes(column), Bytes.toBytes(value));
		Htable.put(p);
		//System.out.println("data inserted");
		Htable.close();
	}
	@Override
	public void Update_Data(String table_name, String rowkey, String column_f, String column, String value) throws IOException {
		Connection conn = ConnectionFactory.createConnection(config);
		Table Htable = conn.getTable(TableName.valueOf(table_name));
		Put p = new Put(Bytes.toBytes(rowkey));
		p.addColumn(Bytes.toBytes(column_f), Bytes.toBytes(column), Bytes.toBytes(value));
		Htable.put(p);
		//System.out.println("data Updated");
		Htable.close();
	}
	@Override
	public Cell[] Read_Data(String table_name, String rowkey) throws IOException {
		Connection conn = ConnectionFactory.createConnection(config);
		Table Htable = conn.getTable(TableName.valueOf(table_name));
		Get g = new Get(Bytes.toBytes(rowkey));
		Result result = Htable.get(g);
		Cell[] cells = result.rawCells();
		return cells;
	}

	@Override
	public void Delete_Data(String rowkey) throws IOException {
		Connection conn = ConnectionFactory.createConnection(config);
		Table Htable = conn.getTable(TableName.valueOf("Weather"));
		Delete deletes = new Delete(Bytes.toBytes(rowkey)) ;
		Htable.delete(deletes);

		Htable.close();
		System.out.println("data deleted.....");
	}

	@Override
	public  ResultScanner  Scan_Table_SingleColumnValueFilter(String table_name, String column_f, String column, String value) throws IOException {
		Connection conn = ConnectionFactory.createConnection(config);
		Table Htable = conn.getTable(TableName.valueOf(table_name));
		Filter filter = new SingleColumnValueFilter(
			    Bytes.toBytes(column_f),
			    Bytes.toBytes(column),
			    CompareOperator.EQUAL,
			    Bytes.toBytes(value)
			);
			Scan scan = new Scan();
			scan.setFilter(filter);
			ResultScanner scanner = Htable.getScanner(scan);
			return scanner;
			
	}
	@Override
	public  ResultScanner  Scan_Table_ColumnValueFilterList
	(String table_name, String column_f1, String column1, String value1, String column_f2, String column2, String value2,String value3) throws IOException {
		Connection conn = ConnectionFactory.createConnection(config);
		Table Htable = conn.getTable(TableName.valueOf(table_name));
		Scan scan = new Scan();
		Filter filter_City = new SingleColumnValueFilter(
			    Bytes.toBytes(column_f1),
			    Bytes.toBytes(column1),
			    CompareOperator.EQUAL,
			    Bytes.toBytes(value1)
			);
		
		Filter filter_time_start = new SingleColumnValueFilter(
			    Bytes.toBytes(column_f2),
			    Bytes.toBytes(column2),
			    CompareFilter.CompareOp.GREATER_OR_EQUAL,
			    Bytes.toBytes(value2)
			);

		Filter filter_time_finish = new SingleColumnValueFilter(
			    Bytes.toBytes(column_f2),
			    Bytes.toBytes(column2),
			    CompareFilter.CompareOp.LESS_OR_EQUAL,
			    Bytes.toBytes(value3)
			);
		
		FilterList filterList = new FilterList(FilterList.Operator.MUST_PASS_ALL);
		filterList.addFilter(filter_City);
		filterList.addFilter(filter_time_start);
		filterList.addFilter(filter_time_finish);

			scan.setFilter(filterList);
			ResultScanner scanner = Htable.getScanner(scan);
			return scanner;
			
	}

	/*public static void main(String[] args) throws IOException {
		Configuration config = HBaseConfiguration.create();
		Connection conn = ConnectionFactory.createConnection(config);
		//Table Htable = conn.getTable(TableName.valueOf("Sinh_Vien"));
		// Put_Data(Htable);
		// Update_Data(Htable);
		//Read_Data(Htable);
		//Delete_Data(Htable);
		Scan_Table("Weather", "Location", "name", "Ho Chi Minh City");
	}*/
}

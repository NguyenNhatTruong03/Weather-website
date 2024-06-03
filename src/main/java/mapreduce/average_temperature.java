package mapreduce;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;
import java.util.StringTokenizer;

public class average_temperature {
    public static boolean runTemperatureAverage(String inputPath, String outputPath) throws Exception {
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf, "temperature average");
        job.setJarByClass(average_temperature.class);
        job.setMapperClass(TemperatureMapper.class);
        job.setReducerClass(TemperatureAverageReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(DoubleWritable.class);

        FileInputFormat.addInputPath(job, new Path(inputPath));
        FileOutputFormat.setOutputPath(job, new Path(outputPath));

        return job.waitForCompletion(true);
    }

    public static class TemperatureMapper extends Mapper<Object, Text, Text, DoubleWritable> {
        private Text city = new Text();
        private DoubleWritable temperature = new DoubleWritable();

        public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
        	StringTokenizer itr = new StringTokenizer(value.toString(), ",");
            if (itr.countTokens() >= 2) {
                String cityName = itr.nextToken();
                String temperatureStr = itr.nextToken();
                try {
                    double temp = Double.parseDouble(temperatureStr);
                    city.set(cityName);
                    temperature.set(temp);
                    context.write(city, temperature);
                } catch (NumberFormatException e) {
                    
                }
            }
        }
    }

    public static class TemperatureAverageReducer extends Reducer<Text, DoubleWritable, Text, DoubleWritable> {
        private DoubleWritable average = new DoubleWritable();

        public void reduce(Text key, Iterable<DoubleWritable> values, Context context) throws IOException, InterruptedException {
            double sum = 0;
            int count = 0;
            for (DoubleWritable val : values) {
                sum += val.get();
                count++;
            }
            double avg = sum / count;
            average.set(avg);
            context.write(key, average);
        }
    }
}

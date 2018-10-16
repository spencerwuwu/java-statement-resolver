        public void reduce( Text key, Iterable<LongWritable> values, Context context )
                throws IOException, InterruptedException{
            ArrayList<Long> outputFlowArray = new ArrayList<Long>();
            for ( LongWritable val : values ){
                outputFlowArray.add( val.get() );
            }
            Long totalOutput = Collections.max( outputFlowArray ) - Collections.min( outputFlowArray );
            String combinerInputKey = key.toString();
            String[] item = combinerInputKey.split( "," );
            String date = item[0];
            String macAdd = item[1];
            String outputKey = date + "," + macAdd;
            context.write( new Text( outputKey ), new LongWritable( totalOutput ) );
        }

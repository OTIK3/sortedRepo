package benchmark;

import org.openjdk.jmh.annotations.*;
import sorts.init.BubbleSort;
import sorts.init.CocktailSort;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 3, time = 1, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.MILLISECONDS)
@Fork(value = 2, warmups = 1)
@Threads(4)
public class TimeSortBenchmark {
    private CocktailSort sort1;
    private BubbleSort sort2;

    @Setup
    public void setup(){
        int size = 10;
        int bound = 100000;
        sort1 = new CocktailSort(size, bound);
        sort2 = new BubbleSort(size, bound);
    }

    @Benchmark
    public void benchmarkBubbleSort(){
        sort1.sort();
    }

    @Benchmark
    public void benchmarkCocktailSort(){
        sort2.sort();
    }

    public static void main(String[] args) throws IOException {
        org.openjdk.jmh.Main.main(args);
    }
}

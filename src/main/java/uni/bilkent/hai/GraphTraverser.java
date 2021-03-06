package uni.bilkent.hai;

import java.util.*;

/**
 * Created by deniz on 09/03/17.
 * Traverses each node in graph. Used to delete edges.
 */
public class GraphTraverser
{
    StateGenerator sg;

    public StateGenerator getStateGenerator() {
        return sg;
    }

    public void setSg(StateGenerator sg) {
        this.sg = sg;
    }

    public GraphTraverser()
    {
        sg = new StateGenerator();
        State start = sg.getStartState();

        Stack<State> path = new Stack<State>();
        Set<State> visited = new HashSet<State>();

        visited.add( start);
        path.add( start);

        while ( !path.isEmpty())
        {
            State cur = path.peek();
            //System.out.println( cur);
            List<State> neighborStates = cur.getNeighborStates();
            boolean deadEnd = true;

            for ( State s : neighborStates)
            {
                if ( !visited.contains( s))
                {
                    path.push(s);
                    s.getNeighborStates().remove( cur);
                    visited.add( s);
                    deadEnd = false;
                    break;
                }
            }

            if ( deadEnd)
                path.pop();
        }

        //System.out.println( visited.size());
    }

}

package netze2gui;

import java.io.Serializable;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by Joncn on 15.06.2015.
 * This is a rule (like forwarding rule on a switch).
 */
public class Rule implements Serializable
{
    private final String[] destinations;
    private final String[] link;
    private final String name;
    private boolean worked = false;
    private boolean working;

    public Rule(String name, boolean working, String[] link, String destination, String... destinations)
    {
        if (destinations != null && destinations.length > 0)
        {
            LinkedList<String> tmp = new LinkedList<>();
            tmp.addFirst(destination);
            tmp.addAll(Arrays.asList(destinations));
            this.destinations = tmp.toArray(destinations);
        } else
        {
            this.destinations = new String[]{destination};
        }
        this.link = link;
        this.name = name;
        this.setWorking(working);
    }

    public Rule(String name, boolean working, String link, String destination, String... destinations)
    {
        if (destinations != null && destinations.length > 0)
        {
            LinkedList<String> tmp = new LinkedList<>();
            tmp.addFirst(destination);
            tmp.addAll(Arrays.asList(destinations));
            this.destinations = tmp.toArray(destinations);
        } else
        {
            this.destinations = new String[]{destination};
        }
        this.link = new String[1];
        this.link[0] = link;
        this.name = name;
        this.setWorking(working);
    }

    public String[] getDestinations()
    {
        return destinations;
    }

    public String[] getLink()
    {
        return link;
    }

    public String getLink(String dest)
    {
        if(dest.contains("A"))
        {
            for(String l : link)
            {
                if(l.contains("A"))
                {
                    return l;
                }
            }
        }
        else if(dest.contains("B"))
        {
            for(String l : link)
            {
                if(l.contains("B"))
                {
                    return l;
                }
            }
        }
        else if(dest.contains("C"))
        {
            for(String l : link)
            {
                if(l.contains("C"))
                {
                    return l;
                }
            }
        }
        return null;
    }

    @Override
    public boolean equals(Object rule2)
    {
        if (rule2 == null)
        {
            return false;
        }
        if (rule2 instanceof Rule)
        {
            Rule rule = (Rule) rule2;
            if (Arrays.equals(this.destinations, rule.destinations) && this.link.equals(rule.getLink()))
            {
                return true;
            }
        }
        return false;
    }

    public boolean isWorking()
    {
        return working;
    }

    public void setWorking(boolean working)
    {
        this.working = working;
    }

    @Override
    public String toString()
    {
        return "Rule \"" + name + "\"";
    }

    public String getName() {return name;}

    public boolean isWorked()
    {
        return worked;
    }

    public void setWorked(boolean worked)
    {
        this.worked = worked;
    }
}

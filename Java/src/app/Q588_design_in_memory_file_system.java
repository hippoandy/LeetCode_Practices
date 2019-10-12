package app;

import java.util.*;

class Q588_design_in_memory_file_system
{
    class FileSystem
    {
        class Obj
        {
            String name;
            boolean isF;
            
            String content;
            Map<String, Obj> children;
            
            public Obj( String name, boolean isFile )
            {
                this.name = name;
                if( isFile )
                {
                    this.isF = true;
                    this.content = "";
                }
                else
                {
                    this.isF = false;
                    this.children = new HashMap<String, Obj>();
                }
            }
            
            public boolean isDirectory() { return this.isF == false; }
            public boolean isFile()      { return this.isF; }
        }
        
        Obj root;
        public FileSystem()
        {
            this.root = new Obj( "/", false );
        }
        
        public List<String> ls(String path)
        {
            Obj ptr = this.root;

            List<String> files = new ArrayList<String>();
            if( !path.equals( "/" ) )
            {
                String[] d = path.split( "/" );
                // move the pointer
                for( int i = 1; i < d.length; i++ ) ptr = ptr.children.get( d[ i ] );
                if( ptr.isFile() )
                {
                    // if the path points to a file, return a list contains only that file
                    files.add( d[ d.length-1 ] );
                    return files;
                }
            }
            // if the path points to a folder, print the content in lexicographic order
            files.addAll( ptr.children.keySet() );
            // sort the result
            Collections.sort( files );
            return files;
        }
        
        public void mkdir(String path)
        {
            Obj ptr = root;
            String[] d = path.split( "/" );
            for( int i = 1; i < d.length; i++ )
            {
                // if the folder not exists, create it
                if( !ptr.children.containsKey( d[ i ] ) )
                    ptr.children.put( d[ i ], new Obj( d[ i ], false ) );
                // navigate
                ptr = ptr.children.get( d[ i ] );
            }
        }
        
        public void addContentToFile(String filePath, String content)
        {
            Obj ptr = root;
            String[] d = filePath.split( "/" );
            // navigate to the parent location of the file (i < d.length-1)
            for( int i = 1; i < d.length-1; i++ ) ptr = ptr.children.get( d[ i ] );
            
            // locate the file
            String name = d[ d.length-1 ];
            if( !ptr.children.containsKey( name ) ) ptr.children.put( name, new Obj( name, true ) );
            // get the file
            ptr = ptr.children.get( name );
            // append the content
            ptr.content = ptr.content + content;
        }
        
        public String readContentFromFile(String filePath)
        {
            Obj ptr = root;
            String[] d = filePath.split( "/" );
            // locate the file
            for( int i = 1; i < d.length-1; i++ ) ptr = ptr.children.get( d[ i ] );
            return ptr.children.get( d[ d.length-1 ] ).content;
        }
    }

    /**
     * Your FileSystem object will be instantiated and called as such:
     * FileSystem obj = new FileSystem();
     * List<String> param_1 = obj.ls(path);
     * obj.mkdir(path);
     * obj.addContentToFile(filePath,content);
     * String param_4 = obj.readContentFromFile(filePath);
     */
}
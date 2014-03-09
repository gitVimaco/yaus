package yaus

class Link {
    String url
    Date dateCreated
    String ip

    static constraints = {
        url url: true
        ip nullable: true
    }
}
